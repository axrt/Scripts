package brainrnaseq;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by alext on 12/5/14.
 */
public class GetFastaNames {


    public static List<String>getFastaNameList(InputStream inputStream) throws IOException {
        final List<String>names;
        try(BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream))){
            names=bufferedReader.lines().filter(line->line.startsWith(">")).map(line->{return line.substring(1);}).collect(Collectors.toList());
        }
        return names;
    }
}
