package pages;

import annotations.Path;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selenide.$$;


@Path("/")
public class MainPage extends AbsBasePage {

    private ElementsCollection dayNewsItemsList = $$("[class='da2727fca3 e65bdf6865']");


    public String getDayNewsItemTitleByIndex(int index) {
        return dayNewsItemsList
                .get(--index)
                .text();
    }


    public void clickDayNewsItemByTitle(String title) {
        dayNewsItemsList
                .filter(Condition.text(title))
                .first().click();
    }
}