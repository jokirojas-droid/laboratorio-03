import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class RegistroAuditoriaBancaria implements AutoCloseable {
    private PrintWriter writer;

    public RegistroAuditoriaBancaria(String archivo) throws IOException {
        writer = new PrintWriter(new FileWriter(archivo, true));
    }

    public void registrar(String mensaje) {
        writer.println("[" + LocalDateTime.now() + "] " + mensaje);
        writer.flush();
    }

    @Override
    public void close() {
        if (writer != null) writer.close();
    }
}
