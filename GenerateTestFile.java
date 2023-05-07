package persnalPrectice;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GenerateTestFile {

    public static final String TEST_DIRECTORY = "test";
    public static final String TEST_FILE = "TEST.txt";

    public static File f;

    public GenerateTestFile() {
        String path = System.getProperty("user.dir") + File.separator + TEST_DIRECTORY;
        f = new File(path);
    }
    public void mkdir() {
        // 폴더 생성: mkdir()
        if (!f.exists()) {	// 폴더가 존재하는지 체크, 없다면 생성
            if (f.mkdir())
                System.out.println("폴더 생성 성공");
            else
                System.out.println("폴더 생성 실패");
        } else {	// 폴더가 존재한다면
            System.out.println("폴더가 이미 존재합니다.");
        }
        System.out.println();
    }
    public void createNewFile() {
        // 파일 생성 : createNewFile()
        mkdir();
        File F = new File(f, TEST_FILE);	// File(디렉토리 객체, 파일명)
        System.out.println(F.getAbsolutePath());

        if (!F.exists()) {	// 파일이 존재하지 않으면 생성
            try {
                if (F.createNewFile())
                    System.out.println("파일 생성 성공");
                else
                    System.out.println("파일 생성 실패");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {	// 파일이 존재한다면
            System.out.println("파일이 이미 존재합니다.");
        }
        System.out.println();
    }
    public void renameTo(String newName) {
        // 파일 이름 변경: renameTo()
        File oldF = new File(f, TEST_FILE);
        File F = new File(f, newName);	// 변경할 이름
        System.out.println(F.getAbsolutePath());

        if (oldF.exists()) {	// 파일이 존재할 때만 이름 변경
            if(oldF.renameTo(F))
                System.out.println("파일 이름 변경 성공");
            else
                System.out.println("파일 이름 변경 실패");
        } else {
            System.out.println("변경할 파일이 없습니다.");
        }
        System.out.println();
    }
    public void delete() {
        // 파일 삭제: delete()
        File F = new File(f, TEST_FILE);
        if (F.exists()) {
            if (F.delete())
                System.out.println("파일 삭제 성공");
            else
                System.out.println("파일 삭제 실패");
        } else {
            System.out.println("삭제할 파일이 없습니다.");
        }
    }
    public void delete(String fileName) {
        // 파일 삭제: delete()
        File F = new File(f, fileName);
        if (F.exists()) {
            if (F.delete())
                System.out.println("파일 삭제 성공");
            else
                System.out.println("파일 삭제 실패");
        } else {
            System.out.println("삭제할 파일이 없습니다.");
        }
    }
}