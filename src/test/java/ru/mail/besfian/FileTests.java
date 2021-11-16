package ru.mail.besfian;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Owner;
import org.apache.commons.io.IOUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileTests {
//    @BeforeAll
//    static void disclosure() {
//        Configuration.startMaximized = true;
//    }
//    @Test
//@Owner("ioomoon")
//@DisplayName("Download PDF file and check it's content")
//void downloadPDFFile() throws IOException {
//    open(http://foxtools.ru/Base64);
//
//    File pdf = $(byText("Download sample pdf file")).download();
//    PDF parsedPdf = new PDF(pdf);
//    Assertions.assertEquals(4, parsedPdf.numberOfPages);
//}
//}
    @Test
    @DisplayName("Работа с .txt файлом (скачивание и поиск по содержимому)")
    void downloadTextFileAndSearchInsideIt() throws IOException {
        open("https://github.com/Besfian/QaGuruLesson7Files/blob/main/build.gradle");
        File download =$("#raw-url").download();
        String fileContent = IOUtils.toString(new FileReader(download));
        assertTrue(fileContent.contains("com.codeborne:selenide:6.0.3"));
        sleep(5000);

    }
    @Test
    @DisplayName("Загрузка файла по относительному пути (рекомендуется!)")
    void filenameShouldDisplayedAfterUploadActionFromClasspathTest() {
        open("https://tools.icoder.uz/file-to-base64-converter.php");
        $("#file").uploadFromClasspath("signature1.png");
        $(".form-control").shouldHave(text("data:image/png;base64"));
        sleep(5000);
    }}