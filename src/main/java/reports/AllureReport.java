package reports;

import cli.CLI;

import java.io.IOException;

public class AllureReport {
    public static void main(String[] args) {
        deleteOutDatedAllureReport();
        installNPMAllureWrapper();
        generateAllureReport();
    }

    public static void deleteOutDatedAllureReport() {
        try {
            if (CLI.executeCommandLine("cd allure-results").contains("allure-results"))
                CLI.executeCommandLine("rmdir allure-results");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void installNPMAllureWrapper() {
        try {
            CLI.executeCommandLine("npm install -g allure-commandline --save-dev");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void generateAllureReport() {
        try {
            CLI.executeCommandLine("allure serve allure-results");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}