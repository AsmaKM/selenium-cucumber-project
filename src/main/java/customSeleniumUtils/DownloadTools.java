package customSeleniumUtils;

//import org.apache.commons.FileUtils;
import properties.ProjectProps;
import utils.AppUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DownloadTools {
    public static void setUpDownloadDirectory(){

        try {
            File downloadPath = new File(ProjectProps.DOWNLOAD_DIR);
            Files.createDirectories(downloadPath.toPath());


        } catch (Exception e){
            System.out.println("Failed to set up Download Directory. " + e);
        }
    }

    public static String getFullNameOfFileWithSubstring(String partialName){
        List<String> filesInDirectory = AppUtils.getFileNamesInDirectory(ProjectProps.DOWNLOAD_DIR);
        return filesInDirectory.stream().filter(name -> name.contains(partialName)).findFirst().orElse(null);
    }

    public static String getAbsolutePathAndNameOfFileWithSubstring(String partialName){
        return Paths.get(ProjectProps.DOWNLOAD_DIR, getFullNameOfFileWithSubstring(partialName))
                .toAbsolutePath()
                .toString();
    }

    public static boolean isFileWithPartialNameInDownloads(String partialName){
        setUpDownloadDirectory();
        if (getFullNameOfFileWithSubstring(partialName) == null) {
            return false;
        }
        return true;
    }

}