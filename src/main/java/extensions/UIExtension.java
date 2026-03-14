package extensions;

import com.codeborne.selenide.Configuration;
import com.google.inject.Guice;
import modules.PageModule;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class UIExtension implements BeforeAllCallback, BeforeEachCallback {

    @Override
    public void beforeAll(ExtensionContext context) {
        Configuration.browser = System.getProperty("browser.type", "chrome");
        Configuration.baseUrl = System.getProperty("ase.url", "https://auto.mail.ru");
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        Guice.createInjector(new PageModule()).injectMembers(context.getTestInstance().get());
    }
}
