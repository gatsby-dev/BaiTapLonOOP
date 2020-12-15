package com.englishpractice.model;

public enum Level {
	EASY {
		@Override
		public String toString() {
			return "Dễ";
		}
	},
	MEDIUM {
		@Override
		public String toString() {
			return "Trung bình";
		}
	},
	HARD {
		@Override
		public String toString() {
			return "Khó";
		}
	}
}
