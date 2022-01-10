import java.util.List;

public class Root implements ToJson{
                public int page;
                public int per_page;
                public int total;
                public int total_pages;
              // public List<Datum> data;
                public Support support;
                public Data data;


  /*  public Root(int page, int per_page, int total, int total_pages, List<Datum> data, Support support) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
        this.support = support;
    }*/

    public Root(int page, int per_page, int total, int total_pages, Support support, Data data) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.support = support;
        this.data = data;
    }

    public Root() {

    }
}



