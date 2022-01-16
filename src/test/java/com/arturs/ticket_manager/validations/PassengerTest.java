package com.arturs.ticket_manager.validations;

import com.arturs.ticket_manager.data.models.Passenger;
import com.arturs.ticket_manager.data.models.PassengerType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PassengerTest {
    private static ValidatorFactory validatorFactory;
    private static Validator validator;

    @BeforeAll
    public static void createValidator() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @AfterAll
    public static void disposeValidator() {
        validatorFactory.close();
    }

    @Test
    void withNegativeBagAmount_shouldThrowError() {
        Passenger passenger = new Passenger(PassengerType.ADULT, -2);
        Set<ConstraintViolation<Passenger>> violations = validator.validate(passenger);

        assertEquals(1, violations.size());
        assertEquals("The bag amount must be positive", violations.iterator().next().getMessage());
    }

    @Test
    void withNullPassengerType_shouldThrowError() {
        Passenger passenger = new Passenger(null, 1);
        Set<ConstraintViolation<Passenger>> violations = validator.validate(passenger);

        assertEquals(1, violations.size());
        assertEquals("Null values are not allowed for passenger type", violations.iterator().next().getMessage());
    }

    @Test
    void withValidPassengerData_shouldNotReturnValidationErrors() {
        Passenger passenger = new Passenger(PassengerType.ADULT, 1);
        Set<ConstraintViolation<Passenger>> violations = validator.validate(passenger);

        assertEquals(0, violations.size());

    }

}
