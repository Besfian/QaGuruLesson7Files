package ru.mail.besfian;

import com.codeborne.pdftest.PDF;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileTests {
    @Test
    @DisplayName("Работа с .txt файлом")
    void txtFileDownload() throws IOException {
        open("https://github.com/Besfian/QaGuruLesson7Files/blob/main/build.gradle");
        File download = $("#raw-url").download();
        String fileContent = IOUtils.toString(new FileReader(download));
        assertTrue(fileContent.contains("com.codeborne:selenide:6.0.3"));
    }

    @Test
    @DisplayName("Загрузка файла по относительному пути")
    void fileUpload() {
        open("https://tools.icoder.uz/file-to-base64-converter.php");
        $("#file").uploadFromClasspath("signature1.png");
        $(".form-control").shouldHave(text("data:image/png;base64"));
    }

    @Test
    @DisplayName("Скачивание PDF файла")
    void pdfFileDownload() throws IOException {
        open("https://github.com/Besfian/QaGuruLesson7Files/blob/main/src/test/resources/portationRequest10.pdf");
        File pdf = $("#raw-url").download();
        PDF parsedPdf = new PDF(pdf);
        Assertions.assertEquals(2, parsedPdf.numberOfPages);
    }
}

