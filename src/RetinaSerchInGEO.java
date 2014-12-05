import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by alext on 12/4/14.
 */
public class RetinaSerchInGEO {

    public static void main(String[] args) {
        final Path input = Paths.get("/Users/alext/Downloads/geoprofiles_result-2.txt");
        final Path output = input.resolveSibling("output.retina.txt");
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input.toFile()));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output.toFile()))) {

            final String text=bufferedReader.lines().collect(Collectors.joining("\n"));
            final String[]split=text.split("\n\n");
            final String out=Arrays.asList(split).stream().filter(line->line.contains("retina")).map(line->{
                final String[]subsplit=line.split("ID: ");
                return subsplit[1];
            }).collect(Collectors.joining(" "));
            bufferedWriter.write(out);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
