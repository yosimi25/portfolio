package com.example.demo;

import jakarta.validation.constraints.Positive;

public class DemoForm {
	private String message;
	private int goal;//ゴール（配列の要素を指定する添字）

	@Positive(message = "1以上の数字を入力してください")
	private long steps;//歩数

	private long lups;//何周
	private int image;//画像を指定
	private String imageName;//画像名

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public int getGoal() {
		return goal;
	}
	public void setGoal(int goal) {
		this.goal = goal;
	}

	public long getSteps() {
		return steps;
	}
	public void setSteps(long steps) {
		this.steps = steps;
	}

	public long getLups() {
		return lups;
	}
	public void setLups(long lups) {
		this.lups = lups;
	}

	public int getImage() {
		return goal;
	}
	public void setImage(int image) {
		this.image = image;
	}

	public String getImageName(int image) {
		switch (image) {
		case 0:
			return "01human.jpg";
		case 1:
			return "02whale.jpg";
		case 2:
			return "03planetarium.jpg";
		case 3:
			return "04pool.jpg";
		case 4:
			return "05argentinosaurus.jpg";
		case 5:
			return "06airplane.jpg";
		case 6:
			return "07fountain.jpg";
		case 7:
			return "08building.jpg";
		case 8:
			return "09fuji.jpg";
		case 9:
			return "10everest.jpg";
		case 10:
			return "11mariana.jpg";
		case 11:
			return "12stratosphere.jpg";
		case 12:
			return "13island.jpg";
		case 13:
			return "14wall.jpg";
		case 14:
			return "15moon.jpg";
		case 15:
			return "16sun.jpg";
		case 16:
			return "17neptune.jpg";
		default:
			return "top.jpg";
		}
	}
	public void setImageName(String imageName) {
	}
}
