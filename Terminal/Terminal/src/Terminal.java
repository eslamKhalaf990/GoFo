import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.*;
import java.util.stream.Stream;

class Parser {
    String commandName;
    String[] args;
    ArrayList<String> listOFCommands = new ArrayList<>();
    public void addToList(){
        listOFCommands.add("cp");
        listOFCommands.add("cp -r");
        listOFCommands.add("rm");
        listOFCommands.add("echo");
        listOFCommands.add("pwd");
        listOFCommands.add("ls");
        listOFCommands.add("ls -r");
        listOFCommands.add("mkdir");
        listOFCommands.add("rmdir");
        listOFCommands.add("touch");
        listOFCommands.add("cat");
        listOFCommands.add("cd");
    }
    public boolean parse(String input){

        addToList();

        commandName ="";
        args = new String[5];

        int i = 0;
        int k=0;

        String temp = "";

        while (input.charAt(i) != ' '){
            commandName += input.charAt(i);
            if (i == input.length()-1){
                break;
            }
            i++;
        }
        while (i<input.length()){
            temp += input.charAt(i);

            if (input.charAt(i) == ' ' || i==input.length()-1){
                args[k] = temp;
                temp ="";
                k++;
            }
            i++;
        }
        if (!listOFCommands.contains(commandName)){
            System.out.println("Command Not Found!");
            return false;
        }
        else return true;

    }
    public String getCommandName(){
        return commandName;
    }
    public String[] getArgs(){
        return args;
    }
}

public class Terminal {
    Parser parser = new Parser();
    public  ArrayList<String> crnt = new ArrayList<String>();
    public int cnt;
    public Terminal() {
        cnt=0;
        String c=System.getProperty("user.dir");
        crnt.add(c);

    }
    public static boolean cd(String directory_name) {
        boolean result = false;  // Boolean indicating whether directory was set
        File directory;       // Desired current working directory

        directory = new File(directory_name).getAbsoluteFile();
        if (directory.exists() || directory.mkdirs())
        {
            result = (System.setProperty("user.dir", directory.getAbsolutePath()) != null);
        }

        return result;
    }
    public void reverseArray(String[] array) {

        List<String> list = Arrays.asList(array);

        Collections.reverse(list);

        String[] Array_r = list.toArray(array);


    }
    public void cp(String[] args){
        try {
            if (args[1] == null ||args[2] ==null){
                throw new IOException("Args");
            }
            Path copyFrom = Paths.get(args[1].strip());
            Path copyTo = Paths.get(args[2].strip());


            Files.copy( copyFrom, copyTo,StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Your File Has Been Copied Successfully!");
        } catch (IOException e) {
            if (e.getMessage().equals("Args")){
                System.out.println("Command Not Found Or Invalid Parameters!");
            }

        }
    }
    public void cp_r(String[] args){
        try {
            if (args[1] == null ||args[2] ==null){
                throw new IOException("Args");
            }
            Path copyFrom = Paths.get(args[2].strip());
            Path copyTo = Paths.get(args[3].strip());

            Stream<Path> dir = Files.walk(copyFrom);

            dir.forEach(file -> {
                try {
                    Files.copy(file, copyTo.resolve(copyFrom.relativize(file)), StandardCopyOption.REPLACE_EXISTING);
                } catch (IOException e){
                    if (e.getMessage().equals("destination")){
                        System.out.println("Destination Directory isn't empty");
                    }
                }
            });
            System.out.println("Your Directory Has Been Copied Successfully!");
            dir.close();
        } catch (IOException e) {
            if (e.getMessage().equals("Args")){
                System.out.println("Command Not Found Or Invalid Parameters!");
            }
        }
    }
    public void rm(String[] args){
        try {
            if (args[1] == null){
                throw new IOException("Args");
            }
            Path path = Paths.get(args[1]);
            Files.delete(path);
            System.out.println("Deleted");
        } catch (IOException e) {
            if (e.getMessage().equals("Args")){
                System.out.println("Command Not Found Or Invalid Parameters!");
            }
        }
    }
    public void cat(String [] args){
        try {
            Path path = Paths.get(args[1].strip());
            List<String> ListOfLines =  Files.readAllLines(path);
            for (int i=0; i<ListOfLines.size();i++) {
                System.out.print(ListOfLines.get(i)+" ");
            }

            if (args[2]!=null){
                Path catPath = Paths.get(args[2].strip());
                List<String> catListOfLines =  Files.readAllLines(catPath);
                for (int i=0; i<catListOfLines.size();i++) {
                    System.out.print(catListOfLines.get(i)+" ");
                }
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void rmdir(String starOrPath)throws IOException {

        if (starOrPath.equals("*")){
            File currentPath = new File(".");
            File arrOfFiles[] = currentPath.listFiles();
            for (File deleteFile : arrOfFiles ){
                if(deleteFile.isDirectory())
                {
                    if(deleteFile.delete() && deleteFile.length() == 0)
                    {
                    }

                }
            }
        }
        else
        {
            File deleteFile = new File(starOrPath);
            if(deleteFile.isDirectory())
            {
                if(deleteFile.delete())
                {
                    System.out.println("deleted");
                }
                else
                {
                    System.out.println("error on deleting");
                }
            }
        }
    }
    public void mkdir(String[] nameOrPath) throws IOException{
        Boolean flag;
        for (int j = 0; j < nameOrPath.length; j++) {
            String pathOrName = nameOrPath[j];
            flag = false;
            if (pathOrName != null) {
                for (int i = 0; i < pathOrName.length(); i++) {
                    Character c = pathOrName.charAt(i);
                    if (c == '\\') {
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    File fileName = new File(pathOrName);

                    if (!fileName.exists()) {
                        fileName.mkdir();
                    }
                }
                if (!flag) {
                    String currentPath = null;
                    try {
                        currentPath = new File(".").getCanonicalPath();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    File fileName = new File(currentPath + '\\' + pathOrName);
                    if (!fileName.exists()) {
                        fileName.mkdir();
                    }
                }
            }
        }
        System.out.println("Directory Has Been Created");
    }
    public void touch(String path) throws IOException {
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void echo(String input ) {
        System.out.println(input);
    }
    public void ls() {

        String currentPath;
        try {
            currentPath = new java.io.File(".").getCanonicalPath();
            File directory;
            directory = new File(currentPath);
            String[]  ch = directory.list();
            if (ch != null){
                for(String child: ch){
                    System.out.println(child);
                }
            }
            else {
                System.out.println("Directory Is Empty!");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void ls_r() {

        String currentPath = null;
        try {
            currentPath = new java.io.File(".").getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File directory = new File(currentPath);
        String[]  ch = directory.list();
        reverseArray(ch);
        for(String child: ch){
            System.out.println(child);
        }
    }
    public String pwd() {
        return (System.getProperty("user.dir"));
    }
    public void chooseCommandAction(){
        Terminal term = new Terminal();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print(">> ");
            String input = scanner.nextLine();
            if (input.equals("exit")){
                break;
            }
            term.parser.parse(input);
            if (term.parser.getArgs()[1] != null && term.parser.getCommandName().equals("cp")){
                if (term.parser.getCommandName().equals("cp") && term.parser.getArgs()[1].strip().equals("-r")){
                    term.cp_r(term.parser.getArgs());
                }
                else if (term.parser.getCommandName().equals("cp")){
                    term.cp(term.parser.getArgs());
                }
            }
            else if (term.parser.getArgs()[1] != null && term.parser.getCommandName().equals("ls")){
                term.ls_r();
            }
            else if (term.parser.getArgs()[1] != null && term.parser.getCommandName().equals("cd")){
                term.cd(term.parser.getArgs()[1]);
            }
            else if (term.parser.getCommandName().equals("cp")){
                term.cp(term.parser.getArgs());
            }
            else if (term.parser.getCommandName().equals("ls")){
                term.ls();
            }
            else if (term.parser.getCommandName().equals("rm")){
                term.rm(term.parser.getArgs());
            }
            else if (term.parser.getCommandName().equals("cat")){
                term.cat(term.parser.getArgs());
            }
            else if (term.parser.getCommandName().equals("mkdir")){
                try {
                    term.mkdir(term.parser.getArgs());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (term.parser.getCommandName().equals("pwd")){
                System.out.println(term.pwd());
            }
            else if (term.parser.getCommandName().equals("echo")){
                term.echo(term.parser.getArgs()[1]);
            }
            else if (term.parser.getCommandName().equals("touch")){
                try {
                    term.touch(term.parser.getArgs()[1]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if (term.parser.getCommandName().equals("rmdir")){
                try {
                    term.rmdir(term.parser.getArgs()[1]);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args){
        Terminal term = new Terminal();
        term.chooseCommandAction();
    }
}