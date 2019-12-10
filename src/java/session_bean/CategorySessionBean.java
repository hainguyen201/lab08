package session_bean;
import entity.Category;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ThanDieu
 */
@Stateless
public class CategorySessionBean extends AbstractSessionBean<Category> {
    
    @PersistenceContext(unitName = "eMarketPU")
    private EntityManager en;

    protected EntityManager getEntityManager() {
        return en;
    }
    
    public CategorySessionBean(){
        super(Category.class);
    }
}
