package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("message", "Let's walk！");
		return "index";
	}

	@RequestMapping("/input")
	public String input(Model model) {
		model.addAttribute("demoForm", new DemoForm());
		return "input";
	}

	@RequestMapping("/output")
	public String output(@Validated @ModelAttribute DemoForm demoForm, BindingResult result,Model model) {
		if (result.hasErrors()) {
			model.addAttribute("validationError","1以上の数字を入力してください");
			return "input";
		}
		model.addAttribute("demoForm",demoForm);
		model.addAttribute("message",message(demoForm.getSteps(),demoForm.getGoal()));
		model.addAttribute("lups",howManyLups(demoForm.getSteps(),demoForm.getGoal()));
		model.addAttribute("image",image(demoForm.getSteps(),demoForm.getGoal()));		
		return "output";
	}

	public static String message(long steps,int goal) {
		DemoForm demoForm = new DemoForm();
		String goals[] = {
				"世界一背の高い人間",
				"シロナガスクジラ",
				"世界最大のプラネタリウム　名古屋市科学館 ドーム直径",
				"世界一深いプール",
				"アルゼンチノサウルス",
				"紙飛行機の最長飛行記録(2022年)",
				"世界一高くまで吹きあがる噴水　サウジアラビアのファハド王の噴水",
				"世界一高いビル　プルジュ・ハリーファ162階建て",
				"富士山",
				"エベレスト",
				"マリアナ海溝",
				"成層圏",
				"世界一孤立している島　トリスタンダクーニャ島（イギリス領）人間が定住する最も近い陸地のセントヘレナ島からの距離まで",
				"万里の長城",
				"地球から月",
				"地球から太陽",
				"太陽から海王星"
		};
		long lups = howManyLups(steps,goal);
		long goalStep[] = {4,42,50,57,64,110,371,1182,4822,12640,15705,142857,3470000,12645428,548571428,213711802857L,6426280630000L};//goalまでの歩数
		if (lups >= 1) {
			demoForm.setMessage(goals[goal] + "を、" + lups + "回超えました");
		} else {
			long leftover = 0;//残りの歩数
			leftover = goalStep[goal] - steps;
			demoForm.setMessage("あと" + leftover + "歩で、" + goals[goal] + "を超えられるよ！！");
		}
		return demoForm.getMessage();
	}

	public static String image(long steps,int goal) {
		long lups = howManyLups(steps,goal);
		DemoForm demoForm = new DemoForm();
		if (lups >= 1) {
			return demoForm.getImageName(goal);		
		} else {
			return demoForm.getImageName(goal);
		}
	}

	public static long howManyLups(long steps,int goal) {
		long lups = 0;//何周
		long goalStep[] = {4,42,50,57,64,110,371,1182,4822,12640,15705,142857,3470000,12645428,548571428,213711802857L,6426280630000L};//goalまでの歩数
		lups = steps / goalStep[goal];
		return lups;
	}
}