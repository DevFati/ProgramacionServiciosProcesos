

package clases;

import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import java.io.IOException;
import java.io.Writer;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

public class ClienteSMTP {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnrecoverableKeyException, KeyStoreException, InvalidKeyException, InvalidKeySpecException {
        if (args.length < 6) {
            System.out.println("Uso: java ClienteSMTP <servidorSMTP> <puerto> <usuario> <clave> <destinatario> <mensaje>");
            return;
        }

        String servidorSMTP = args[0];  
        int puerto = Integer.parseInt(args[1]);  
        String usuario = args[2];  
        String clave = args[3];  
        String destinatario = args[4];  
        String mensaje = args[5];  

        AuthenticatingSMTPClient client = new AuthenticatingSMTPClient(); // ✅ Se usa AuthenticatingSMTPClient

        try {
            int respuesta;

            // 🔹 Crear un KeyManager para habilitar TLS
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(null, null);
            KeyManager km = kmf.getKeyManagers()[0];

            // 🔹 Conectar al servidor SMTP
            client.connect(servidorSMTP, puerto);
            System.out.println("🔌 Conectado a " + servidorSMTP);
            System.out.println("Respuesta: " + client.getReplyString());

            respuesta = client.getReplyCode();
            if (!SMTPReply.isPositiveCompletion(respuesta)) {
                client.disconnect();
                System.err.println("❌ CONEXIÓN RECHAZADA.");
                System.exit(1);
            }

            // 🔹 Establecer el KeyManager para TLS
            client.setKeyManager(km);

            // 🔹 Enviar EHLO antes de iniciar TLS
            client.ehlo("localhost");
            System.out.println("Servidor (antes de TLS): " + client.getReplyString());

            // 🔹 Habilitar STARTTLS
            System.out.println("🔐 Activando STARTTLS...");
            if (!client.execTLS()) {
                System.err.println("❌ ERROR: No se pudo activar STARTTLS.");
                client.disconnect();
                System.exit(1);
            }

            // 🔹 Enviar EHLO después de activar TLS
            client.ehlo("localhost");
            System.out.println("Servidor (después de TLS): " + client.getReplyString());

            // 🔹 Autenticación SMTP
            System.out.println("🔐 Intentando autenticación...");
            if (!client.auth(AuthenticatingSMTPClient.AUTH_METHOD.LOGIN, usuario, clave)) {
                System.err.println("❌ ERROR: Autenticación fallida.");
                client.disconnect();
                System.exit(1);
            }
            System.out.println("✅ Autenticación exitosa.");

            // 🔹 Crear cabecera del correo
            SimpleSMTPHeader header = new SimpleSMTPHeader(usuario, destinatario, "Prueba desde Java");

            // 🔹 Establecer remitente y destinatario
            client.setSender(usuario);
            client.addRecipient(destinatario);

            // 🔹 Enviar DATA
            Writer writer = client.sendMessageData();
            if (writer == null) {
                System.err.println("❌ ERROR: El servidor rechazó el inicio del mensaje.");
                client.disconnect();
                System.exit(1);
            }

            writer.write(header.toString());  // Encabezado del correo
            writer.write(mensaje);  // Cuerpo del mensaje
            writer.close();

            // 🔹 Finalizar el envío
            if (!client.completePendingCommand()) {
                System.err.println("❌ ERROR: No se pudo enviar el mensaje.");
                client.disconnect();
                System.exit(1);
            }

            System.out.println("📧 Correo enviado correctamente a " + destinatario);

        } catch (IOException e) {
            System.err.println("❌ ERROR: No se pudo conectar.");
            e.printStackTrace();
        } finally {
            try {
                client.disconnect();
                System.out.println("🔌 Desconectado del servidor SMTP.");
            } catch (IOException e) {
                System.err.println("❌ ERROR al desconectar.");
                e.printStackTrace();
            }
        }
    }
}
