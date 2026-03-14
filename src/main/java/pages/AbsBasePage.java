package pages;

import annotations.Path;
import annotations.PathTemplete;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import exceptions.PathNotFoundException;

import static com.codeborne.selenide.Selenide.$;

public abstract class AbsBasePage {

    private String getPath(String... data) {
        Class<?> clazz = getClass();
        if (clazz.isAnnotationPresent(PathTemplete.class)) {
            PathTemplete pathTemplete = clazz.getDeclaredAnnotation(PathTemplete.class);
            String template = pathTemplete.value();
            int i = 0;
            for (String pathData : data) {
                template = template.replace("$" + (i + 1), pathData);
                i++;
            }
            return template;
        }
        if (clazz.isAnnotationPresent(Path.class)) {
            Path path = clazz.getDeclaredAnnotation(Path.class);
            return path.value();
        }
        throw new PathNotFoundException();
    }


//    protected String getPath() {
//        Type genericSuperclass = this.getClass().getGenericSuperclass();
//        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;
//        Class<?> rawType = (Class<?>) parameterizedType.getActualTypeArguments()[0];
//
//        if (rawType.isAnnotationPresent(Path.class)) {
//            return rawType.getDeclaredAnnotation(Path.class).value();
//        }
//        throw new PathNotFoundException();
//    }


    public void open(String... data) {
        Selenide.open(getPath(data));
    }

    public void headerShouldBeSameAs(String expectedHeader) {
        $("h1").shouldBe(Condition.text(expectedHeader));
    }
}
