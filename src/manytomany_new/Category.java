/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manytomany_new;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author nuwan600
 */
public class Category {
    
     private Integer categoryId;
    private String name;
    private String desc;
    private Set<Stock> stocks = new HashSet<Stock>(0);
    
    public  Category(int theid, String thename,String thedesc)
    {
        this.setCategoryId(theid);
        this.setName(thename);
        this.setDesc(thedesc);
    }

        public Integer getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Integer categoryId) {
            this.categoryId = categoryId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public Set<Stock> getStocks() {
            return stocks;
        }

        public void setStocks(Set<Stock> stocks) {
            this.stocks = stocks;
        }
    
}
