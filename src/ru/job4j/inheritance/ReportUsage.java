package ru.job4j.inheritance;

public class ReportUsage {
    public static void main(String[] args) {
        TextReport report = new TextReport();
        String text = report.generate("Report's name", "Report's body");
        System.out.println(text);

        HtmlReport report2 = new HtmlReport();
        text = report2.generate("Report's name", "Report's body");
        System.out.println(text);

        JSONReport report3 = new JSONReport();
        text = report3.generate("Report's name", "Report's body");
        System.out.println(text);
    }
}
