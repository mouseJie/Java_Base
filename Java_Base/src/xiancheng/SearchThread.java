package xiancheng;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
 
public class SearchThread {
    File file;
    String search;
 
    public static void main(String[] args) {
        ThreadPoolExecutor threafPool=new ThreadPoolExecutor(10, 15, 60, TimeUnit.SECONDS, new LinkedBlockingQueue() );
        String s="test3";
        File file=new File("F://java2test");
        SearchThread st=new SearchThread(file, s);
        st.search(threafPool);
    }
 
    public SearchThread(File file, String search) {
        super();
        this.file = file;
        this.search = search;
 
    }
 
    public void search(ThreadPoolExecutor threafPool) {
        threafPool.execute(new Runnable() {
 
            @Override
            public void run() {
                search(search, file);
 
            }
        });
    }
 
    public void search(String search, File file) {
        if (file.getName().toLowerCase().endsWith(".java")) {
            if (file.isFile()) {
                if (file.getName().toLowerCase().endsWith(".java")) {
 
                }
                try (FileReader fr = new FileReader(file);) {
                    char[] cs = new char[(int) file.length()];
                    fr.read(cs);
                    if (new String(cs).contains(search)) {
                        System.out.printf("找到含有%s的文件，路径是:%s%n", search, file);
                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
 
            }
        }
 
        if (file.isDirectory()) {
            File[] fs = file.listFiles();
            for (File f : fs) {
                search(search, f);
            }
        }
    }
 
}
