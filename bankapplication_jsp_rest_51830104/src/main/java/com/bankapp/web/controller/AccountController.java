package com.bankapp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.repo.CustomerRepository;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.UserService;
import com.bankapp.web.controller.beans.AccountBean;
import com.bankapp.web.controller.beans.TransferRequest;
import com.bankapp.web.controller.beans.WithDrawAndDepositRequest;

@Controller
public class AccountController {
	@Autowired
	private AccountService accountService;
@Autowired
private CustomerRepository customerRepository;
@Autowired
private UserService userService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String homeGet(AccountBean accountBean, ModelMap map) {
		map.addAttribute("accountBean", new AccountBean());
		return "home";
	}
	@RequestMapping(value = "/mylogin", method = RequestMethod.GET)
	public String myLogin() {
		//map.addAttribute("accountBean", new AccountBean());
		return "mylogin";
	}


	@GetMapping(value = "/allaccounts")
	public String allaccounts(ModelMap mv) {
		mv.addAttribute("accounts", accountService.getAllAccounts());
			return "allaccounts";
	}
	@GetMapping(value = "/allcustomers")
	public String allcustomers(ModelMap mv) {
		mv.addAttribute("customers", customerRepository.findAll());
			return "allcustomers";
	}
	@GetMapping(value = "/allusers")
	public String allusers(ModelMap mv) {
		mv.addAttribute("allUsers", userService.findAll());
			return "allusers";
	}
	/*@RequestMapping(value = "/home", method = RequestMethod.POST)
	public String homePost(AccountBean accountBean) {
		accountService.transfer(accountBean.getFrom(), accountBean.getTo(), accountBean.getAmount());
		return "success";
	}*/

	@RequestMapping(value = "/addaccount", method = RequestMethod.GET)
	public String addaccountGet(ModelMap map) {
		map.addAttribute("account", new AccountBean());
		return "addaccount";
	}

	@RequestMapping(value = "/addaccount", method = RequestMethod.POST)
	public String addAccountUpdatePost(ModelMap map,@ModelAttribute(name="account")AccountBean bean) {
		Account account=new Account(bean.getAccountBalance(), false);
		Customer customer=new Customer(bean.getName(), bean.getEmail(), bean.getPhone(), bean.getAddress(),bean.getCity(), bean.getCountry());
	account.setCustomer(customer);
	//customer.setAccount(account);
	accountService.createAccount(account);
	return "redirect:allaccounts";
	}
	
	
	@RequestMapping(value="/transfer", method=RequestMethod.GET)
	public ModelAndView transferfund(ModelAndView mv){
		mv.setViewName("transfer");
		mv.addObject("TransferRequest", new TransferRequest());
		return mv;
	}
	
	@RequestMapping(value="/transfer", method=RequestMethod.POST)
	public String transferfundPost(@Valid @ModelAttribute("transfer")
	TransferRequest transferRequest,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "transfer";
		}
		accountService.transfer(transferRequest.getFromaccount(),
				transferRequest.getToaccount(), transferRequest.getAmount(), transferRequest.getAuthname());
		return "redirect:allaccounts";
		
	}
	
	@RequestMapping(value="/deposit", method=RequestMethod.GET)
	public ModelAndView depositGet(ModelAndView mv){
		mv.setViewName("deposit");
		mv.addObject("withdrawdepositbean",new WithDrawAndDepositRequest());
		return mv;
	}
	
	@RequestMapping(value="/depositpost", method=RequestMethod.POST)
	public String depositPost(@Valid @ModelAttribute("withdrawdepositbean")
	WithDrawAndDepositRequest withDrawDepositRequest,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "deposit";
		}
		accountService.deposit(withDrawDepositRequest.getAccountNumber(), withDrawDepositRequest.getAmount());
		
		return "redirect:allaccounts";
	}
	@RequestMapping(value="/withdraw", method=RequestMethod.GET)
	public ModelAndView withdrawGet(ModelAndView mv){
		mv.setViewName("withdraw");
		mv.addObject("withdrawdepositbean",new WithDrawAndDepositRequest());
		return mv;
	}
	
	@RequestMapping(value="/withdrawpost", method=RequestMethod.POST)
	public String withdrawPost(@Valid @ModelAttribute("withdrawdepositbean")
	WithDrawAndDepositRequest withDrawDepositRequest,BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "withdraw";
		}
		accountService.withdraw(withDrawDepositRequest.getAccountNumber(), withDrawDepositRequest.getAmount());
		
		return "redirect:allaccounts";
	}
	

@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteAccount(HttpServletRequest req) {
		long accountNo = Integer.parseInt(req.getParameter("id"));
		accountService.deleteAccount(accountNo);
		return "redirect:allaccounts";
	}

@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateAccountGet(HttpServletRequest req, ModelMap map) {
		int accountNo = Integer.parseInt(req.getParameter("id"));
		Account accountToBeUpdate = accountService.findByAccountNumber(accountNo);
		map.addAttribute("account", accountToBeUpdate);
		return "addaccount";
	}

	@RequestMapping(value = "/first")
	public String first() {
		return "first";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin() {
		return "admin";
	}

	@RequestMapping(value = "/mgr", method = RequestMethod.GET)
	public String mgr() {
		return "mgr";
	}

	@RequestMapping(value = "/clerk", method = RequestMethod.GET)
	public String clerk() {
		return "clerk";
	}

}
