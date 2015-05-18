package com.mcms.study.spring.batch.scheduler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class FileArchivingTasklet implements Tasklet {

    private static final Logger log = LoggerFactory.getLogger(FileArchivingTasklet.class);
    private File archiveDirectory;
    private String archiveDirectoryPath = "src/test/resources/archivedFiles";

    public void init() {
        archiveDirectory = new File(archiveDirectoryPath);
    }

    public void archiveFile(String fileName) throws IOException {
        log.info("Archiving file: " + fileName);
        File file = new File(fileName);
        File targetFile = new File(archiveDirectory, file.getName() + getSuffix());
        FileUtils.copyFile(file, targetFile);
    }

    public String getSuffix() {
        return "_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new DateTime(DateTimeZone.UTC).toDate());
    }

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        Map<String, Object> map = chunkContext.getStepContext().getJobParameters();
        String fileName = (String) map.get("examResultInputFile");
        archiveFile(fileName);
        return RepeatStatus.FINISHED;
    }

}
