package ispan.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ispan.model.Customer;
import ispan.model.CustomerRepository;

@RestController
public class CustomerController {

	@Autowired
	CustomerRepository customerRepository;

	@PostMapping("/customer/insert")
	private Customer insertCustomer() {
		//臨時物件
		Customer customer1 = new Customer();
		customer1.setName("安安");
		customer1.setLevel(1);
		//儲存到資料庫，轉換物件狀態
		Customer responseCustomer = customerRepository.save(customer1);
		//將資料回傳到前端
		return responseCustomer;
	}
	
	@PostMapping("/customer/insert2")
	private Customer insertCustomer2(@RequestBody Customer customer) {
		//儲存到資料庫，轉換物件狀態
		Customer responseCustomer = customerRepository.save(customer);
		//將資料回傳到前端
		return responseCustomer;
	}
	
	@PostMapping("/customer/insert3")
	private List<Customer> insertCustomer3(@RequestBody List<Customer> customers) {
		//儲存到資料庫，轉換物件狀態
		List<Customer> responseCustomers = customerRepository.saveAll(customers);
		//將資料回傳到前端
		return responseCustomers;
	}
						   //路徑變數
	@GetMapping("/customer/get/{id}")
	private Customer findById(@PathVariable("id") Long id) {
		//null意思含糊，故用Optional，看存不存在
		Optional<Customer> customer=customerRepository.findById(id);
		if(customer.isPresent()) {
			return customer.get();
		}
			Customer emptyCustomer = new Customer();
			emptyCustomer.setName("沒有這筆資料");
			return emptyCustomer;
	}
	
	@GetMapping("/customer/page/{pageNumber}")
	private List<Customer> findByPage(@PathVariable Integer pageNumber){
		      //第0頁開始，如果是第二頁，開起來數字會是第三頁，因此頁數要-1
		PageRequest pageable = PageRequest.of(pageNumber-1, 3, Sort.Direction.ASC,"id");
					 //    頁數 ,每頁幾筆資料, 排序 ,以什麼為基準排序
		Page<Customer> page = customerRepository.findAll(pageable);
		List<Customer> list = page.getContent();
		return list;
	}
	
	@GetMapping("/customer/findByName")
	private List<Customer> findCustomerByName(@RequestParam String name){
		return customerRepository.findCustomerByName(name);
	}
	
	@GetMapping("/customer/findByLevel")
	private List<Customer> findCustomerByLevel(@RequestParam Integer level, @RequestParam String name){
		return customerRepository.findCustomerByLevel(level,name);
	}
	@GetMapping("/customer/delete/{id}")
	public boolean deleteCustomerById(@PathVariable Long id) {
		customerRepository.deleteCustomerById(id);
		return true;
	}
}
