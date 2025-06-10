package ru.neoflex.practice;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import ru.neoflex.practice.controller.CalcController;
import ru.neoflex.practice.controller.repository.CalculationResultRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = ru.neoflex.practice.controller.CalcController.class)
class PracticeApplicationTests {
	private CalcController calcController;
	private CalculationResultRepository repository;

	@BeforeEach
	void setup() {
		repository = mock(CalculationResultRepository.class);
		calcController = new CalcController(repository); // передаём мок в конструктор
	}

	@Test
	void testPlus() {
		int result = calcController.plus(10, 5);
		assertThat(result).isEqualTo(15);
		verify(repository).save(any());
	}

	@Test
	void testMinus() {
		int result = calcController.minus(10, 5);
		assertThat(result).isEqualTo(5);
		verify(repository).save(any());
	}
}
