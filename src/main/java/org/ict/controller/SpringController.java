package org.ict.controller;

import java.util.ArrayList;

import org.ict.domain.BaseVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
// 기본 url(localhost:8181/ 뒤에 spring/모든패턴 이 추가됨.
@RequestMapping("/spring/*")
public class SpringController {

	@RequestMapping("")
	public void base() {

		System.out.println("기본 url로 접속했습니다.");
	}

	@RequestMapping(value = "/base", method = { RequestMethod.GET, RequestMethod.POST })
	public void baseGet() {
		System.out.println("base Get");
	}

	@RequestMapping(value = "/base")
	public void baseGet2() {
		System.out.println("base Get2z");
	}

	@PostMapping("/basePost")
	public void basePost() {

		System.out.println("그냥 접속할 수 없는 POST");
	}

	@GetMapping("/ict")
	public void ict() {

		System.out.println("ICT 인재개발원 입니다.");

	}

	// return 타입이 String인 경우는 url주소를 무시하고 곧바로 리턴된 문자열. jsp를
	// views 폴더 하위에 배치해야합니다.
	@GetMapping("/vo")
	public String vo01(BaseVO vo) {

		System.out.println("" + vo);
		return "vo01";
	}

	// vo02.jsp를 spring폴더 하위에 저장하는 메서드 vo02를 작성. 내부 코드는 vo01과 일치.
	@GetMapping("/vo2")
	// 스프링에서는 Model이라는 객체를 이용해 컨트롤러의 데이터를 뷰로 보내줍니다.
	// 메서드의 파라미터 선언부에 Model객체를 선언합니다.

	public String vo02(Model model, BaseVO vo) {
		System.out.println("" + vo);
		model.addAttribute("BaseVO", vo);
		return "spring/vo02";
	}

	@GetMapping("/vo3")
	public String vo3(BaseVO vo, @ModelAttribute("num") int num, Model model) {
		System.out.println("회원 번호 : " + num);
//		model.addAttribute("num", num);
		return "/spring/vo03";
	}

	@GetMapping("/qwer")
	public String redirecTest() {
		System.out.println("/base로 redirect");
		return "redirect:/spring/";
	}

	@GetMapping("/exUpload")
	public void exUpload() {
		System.out.println("/exUpload...");

	}

	@PostMapping("/exUploadPost")
	public void exUploadPost(ArrayList<MultipartFile> files) {
		files.forEach(file -> {
			System.out.println("==========================");
			System.out.println("name : " + file.getOriginalFilename());
			System.out.println("size : " + file.getSize() );
		});
	}

}
