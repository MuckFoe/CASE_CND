package com.example.demo.domain;

import java.util.List;

public interface CalenderTypeRepository {
    CalenderType save(CalenderType calenderType);

    List<CalenderType> findAll();
}
