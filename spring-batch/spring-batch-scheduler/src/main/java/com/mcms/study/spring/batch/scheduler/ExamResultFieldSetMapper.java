package com.mcms.study.spring.batch.scheduler;

import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.mcms.study.spring.batch.scheduler.model.ExamResult;

public class ExamResultFieldSetMapper implements FieldSetMapper<ExamResult> {

    private static final Logger log = LoggerFactory.getLogger(ExamResultFieldSetMapper.class);

    public ExamResult mapFieldSet(FieldSet fieldSet) throws BindException {
        log.info("mapFieldSet mapFieldSet Called!!!!!");
        ExamResult result = new ExamResult();
        result.setStudentName(fieldSet.readString(0));
        result.setDob(new LocalDate(fieldSet.readDate(1, "dd/MM/yyyy")));
        result.setPercentage(fieldSet.readDouble(2));
        log.info("ExamResultFieldSetMapper -> " + result.toString());
        return result;
    }

}
