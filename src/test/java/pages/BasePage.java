package pages;

import pages.components.CalendarComponent;
import pages.components.SubjectComponent;
import pages.components.TableComponent;
import tests.testdata.TestData;

public class BasePage {
    TableComponent tableComponent = new TableComponent();
    SubjectComponent subject = new SubjectComponent();
    CalendarComponent calendar = new CalendarComponent();
    TestData testData = new TestData();
}
