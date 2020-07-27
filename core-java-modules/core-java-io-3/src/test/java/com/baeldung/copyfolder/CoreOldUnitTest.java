package com.baeldung.copyfolder;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CoreOldUnitTest {

    private final String sourceFolderLocation = "src/test/resources/sourceFolder";
    private final String subFolderName = "/childFolder";
    private final String fileName = "/file.txt";
    private final String destinationFolderLocation = "src/test/resources/destinationFolder";

    @BeforeEach
    public void createFolderWithSubfolderAndFile() throws IOException {
        Files.createDirectories(Paths.get(sourceFolderLocation));
        Files.createDirectories(Paths.get(sourceFolderLocation + subFolderName));
        Files.createFile(Paths.get(sourceFolderLocation + subFolderName + fileName));
    }

    @Test
    public void whenSourceFolderExists_thenFolderIsFullyCopied() throws IOException {
        File sourceFolder = new File(sourceFolderLocation);
        File destinationFolder = new File(destinationFolderLocation);
        CoreOld.copyDirectoryJavaUnder7(sourceFolder, destinationFolder);

        assertTrue(new File(destinationFolderLocation).exists());
        assertTrue(new File(destinationFolderLocation + subFolderName).exists());
        assertTrue(new File(destinationFolderLocation + subFolderName + fileName).exists());
    }

    @Test
    public void whenSourceFolderDoesNotExist_thenExceptionIsThrown() throws IOException {
        File sourceFolder = new File("nonExistingFolder");
        File destinationFolder = new File(destinationFolderLocation);
        assertThrows(IOException.class, () -> CoreOld.copyDirectoryJavaUnder7(sourceFolder, destinationFolder));
    }

    @AfterEach
    public void cleanUp() throws IOException {
        Files.walk(Paths.get(sourceFolderLocation))
            .sorted(Comparator.reverseOrder())
            .map(Path::toFile)
            .forEach(File::delete);
        if (new File(destinationFolderLocation).exists()) {
            Files.walk(Paths.get(destinationFolderLocation))
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);
        }
    }

}
