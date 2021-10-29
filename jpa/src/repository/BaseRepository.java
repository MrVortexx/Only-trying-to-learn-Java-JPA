package repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

public  class BaseRepository<T> {
    private Class<T> entity;
    private static EntityManagerFactory emf;
    private EntityManager em;

    static {
        try{
            emf = Persistence.createEntityManagerFactory("jpa");
        }catch(Exception e){
        }  
    }
    @Transactional
    public T create (T entity){
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(entity);
        tx.commit();

        return entity;
    }
    public void closeEm(){
        em.close();
    }

    public BaseRepository(){
        this(null);
    }

    public BaseRepository(Class <T> entity){
        this.entity = entity;
        em = emf.createEntityManager();
    }

    public T getEntityByUuid(String uuid) {
        EntityManagerFactory fac = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = fac.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        String query = "SELECT e FROM " + this.entity.getName() + " e  WHERE uuid = :u" ;

        TypedQuery<T>  queryResult = em.createQuery(query, entity);
        queryResult.setParameter("u", uuid);
        
        return queryResult.getSingleResult();
    }



}
