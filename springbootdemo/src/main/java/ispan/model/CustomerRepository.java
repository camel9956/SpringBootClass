package ispan.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
									
public interface CustomerRepository extends JpaRepository<Customer, Long> {
//                                                <Customer資料型別, id資料型別>
//對Entity操作
	//HQL( =?xxx)		  
	@Query(value = "from Customer where name = ?1")
	List<Customer> findCustomerByName(String name);
	
	//HQL( =:xxx)
	@Query(value = "from Customer where name = :name")
	List<Customer> findCustomerByName2(@Param("name") String name);
	
//對Table操作
	//原生SQL
	@Query(value = "select * from Customer where name = :name",nativeQuery=true)
	List<Customer> findCustomerByName3(@Param("name") String name);
	
	//找出某level的customer資料
	//兩個條件以上
	@Query(value = "from Customer where level = :level and name=:name")
	List<Customer> findCustomerByLevel(@Param("level") Integer level,@Param("name") String name);
	
	//delete需用Modifiy
	//使用原生SQL
	@Transactional
	@Modifying
	@Query(value = "delete from customer where id = ?1",nativeQuery = true)
	public void deleteCustomerById(@Param("id") Long id);
}
