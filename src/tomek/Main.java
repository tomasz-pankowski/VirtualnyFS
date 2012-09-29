package tomek;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.spi.FileSystemProvider;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Path jarfile = Paths.get("/home/punki/test.zip");
        FileSystem fs = FileSystems.newFileSystem(jarfile, null);
        Path path = fs.getPath("tekst.txt");
        System.out.println("path.toString() = " + path.toString());
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        Files.copy(path, outputStream);
        System.out.println("bytes = " + new String(outputStream.toByteArray()));
        List<String> lines = Files.readAllLines(path, Charset.defaultCharset());
        for (String line : lines) {
            System.out.println("line = " + line);
        }

    }
}
