package reports;

import cli.CLI;

import java.io.IOException;

public class AllureReport {
    public static void main(String[] args) throws IOException {
        deleteOutDatedAllureReport();
        installNPMAllureWrapper();
        generateAllureReport();
    }
    public static void deleteOutDatedAllureReport() throws IOException {
        CLI.executeCommandLine("cd allure-results");
        CLI.executeCommandLine("DEL /S /Q *.json");
    }

    public static void installNPMAllureWrapper() throws IOException {
        CLI.executeCommandLine("npm install -g allure-commandline --save-dev");
    }
    public static void generateAllureReport() throws IOException {
        CLI.executeCommandLine("allure serve allure-results");
    }
}