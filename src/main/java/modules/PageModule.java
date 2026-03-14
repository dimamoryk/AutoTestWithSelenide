package modules;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import pages.ArticlePage;
import pages.MainPage;

public class PageModule extends AbstractModule {

    @Provides
    public MainPage getmainPage() {
        return new MainPage();
    }

    @Provides
    public ArticlePage getarticlePage() {
        return new ArticlePage();
    }
}
