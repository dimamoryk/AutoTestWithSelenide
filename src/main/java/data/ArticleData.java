package data;

public enum ArticleData {

    ARTICLE_DATA("119532-nazvanyi-camyie-vazhnyie-novinki-rossijskogo-avtoryinka-vesnoj-2026-goda/");

    private String path;

     ArticleData(String path){
        this.path = path;
    }
    public String getPath(){
         return path;
    }
}
