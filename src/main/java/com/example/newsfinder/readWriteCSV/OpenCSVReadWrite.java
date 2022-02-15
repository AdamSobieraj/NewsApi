package com.example.newsfinder.readWriteCSV;

import com.kwabenaberko.newsapilib.models.Article;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class OpenCSVReadWrite {

    private static final String FILE_NAME = "news.csv";

    public static void wtriteWithOpenCSV(List<Article> news) throws IOException {
        File file = new File(FILE_NAME);

            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);

            List<String[]> data = new ArrayList<>();

            for (Article article : news) {
                data.add(new String[] {article.getAuthor(),article.getDescription(), article.getTitle()});
            }

            writer.writeAll(data);
            writer.close();
    }

}

