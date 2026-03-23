package main;

import com.google.inject.Inject;
import data.ArticleData;
import extensions.UIExtension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.ArticlePage;
import pages.MainPage;

@ExtendWith(UIExtension.class)
public class ClickArticleTitleBlock_Test {

    @Inject
    private MainPage mainPage;
    @Inject
    private ArticlePage articlePage;

    @Test
    public void clickDayNewsTitle() {
        articlePage.open(ArticleData.ARTICLE_DATA.getPath());
        mainPage.open();
        String title = mainPage.getDayNewsItemTitleByIndex(-1);
        mainPage.clickDayNewsItemByTitle(title);

        articlePage.headerShouldBeSameAs(title);
    }
}
