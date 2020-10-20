package payroll;

import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;
import java.util.stream.IntStream;

class NioFileAPITest {

	private static String HOME = System.getProperty("user.home");
	private static String PLAY_WITH_NIO = "TempPlayGround";

	/**
	 * Usecase2 for File operations
	 * 
	 * @throws IOException
	 */
	@Test
	public void givenPath_WhenChecked_ThenConfirm() throws IOException {
		// Check File Exists
		Path homePath = Paths.get(HOME);
		assertTrue(Files.exists(homePath));

		// Delete File and Check File Not Exists
		Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
		if (Files.exists(playPath)) {
			FileUtils.deleteFiles(playPath.toFile());
		}
		assertTrue(Files.notExists(playPath));

		// Create Directory
		Files.createDirectory(playPath); // Created TempPlayGround directory
		assertTrue(Files.exists(playPath));

		// Create files in the directory
		IntStream.range(1, 10).forEach(cntr -> {
			Path tempFile = Paths.get(playPath + "/temp" + cntr);
			assertTrue(Files.notExists(tempFile));
			try {
				Files.createFile(tempFile);
			} catch (IOException e) {
			}
			assertTrue(Files.exists(tempFile));

		});

		Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
		Files.newDirectoryStream(playPath).forEach(System.out::println);
		Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString().startsWith("temp"))
				.forEach(System.out::println);
	}
	
	/**
	 * Usecase3 for implementation of WatchService
	 * 
	 * @throws IOException
	 */
	@Test
	public void givenADirectory_WhenWatched_ListAllTheActivities() throws IOException {
		Path dir = Paths.get(HOME +"/" + PLAY_WITH_NIO);
		Files.list(dir).filter(Files::isRegularFile).forEach(System.out::println);
		new Java8WatchService(dir).processEvents();
	}
}