//package com.jya.erp.task.domain;
//
//
//
//import javax.persistence.*;
//import java.util.Date;
//
///**
// * Created by cx on 2017/6/14.
// */
//@Entity
//@Table(name = "t_task2")
//public class Task {
//
//    public enum TaskState {
//        run("运行"), stop("暂停"),;
//
//        private String name;
//
//        TaskState(String name) {
//            this.name = name;
//        }
//
//        public String getName() {
//            return name;
//        }
//    }
//
//    public enum UrlTypeState {
//        eureka("eureka"), outing("outing"),;
//
//        private String value;
//
//        UrlTypeState(String value) {
//            this.value = value;
//        }
//
//        public String getValue() {
//            return value;
//        }
//    }
//
//    public static Task of() {
//        return new Task();
//    }
//
//
//    @Id
//    @SequenceGenerator(name = "task_generator", sequenceName = "seq_t_task", initialValue = 100)
//    @GeneratedValue(generator = "task_generator")
//    private Long id;
//
//    @Column(nullable = false)
//    private String url;
//
//    @Column(unique = true)
//    private String code;
//
//    private String name;
//
//    @Column(nullable = false)
//    private String cron;
//
//    private Date lastRunTime;
//
//    @Enumerated(EnumType.STRING)
//    private UrlTypeState urlType;
//
//    @Column(nullable = false)
//    private Integer runtimes;
//
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private TaskState state;
//
//    private String memo;
//
//    @PrePersist
//    void preInsert() {
//        if (runtimes == null) {
//            runtimes = 0;
//        }
//    }
//
//    public String getCode() {
//        return code;
//    }
//
//    public void setCode(String code) {
//        this.code = code;
//    }
//
//    public UrlTypeState getUrlType() {
//        return urlType;
//    }
//
//    public void setUrlType(UrlTypeState urlType) {
//        this.urlType = urlType;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUrl() {
//        return url;
//    }
//
//    public void setUrl(String url) {
//        this.url = url;
//    }
//
//    public String getCron() {
//        return cron;
//    }
//
//    public void setCron(String cron) {
//        this.cron = cron;
//    }
//
//    public TaskState getState() {
//        return state;
//    }
//
//    public void setState(TaskState state) {
//        this.state = state;
//    }
//
//    public Date getLastRunTime() {
//        return lastRunTime;
//    }
//
//    public void setLastRunTime(Date lastRunTime) {
//        this.lastRunTime = lastRunTime;
//    }
//
//    public Integer getRuntimes() {
//        return runtimes;
//    }
//
//    public void setRuntimes(Integer runtimes) {
//        this.runtimes = runtimes;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getMemo() {
//        return memo;
//    }
//
//    public void setMemo(String memo) {
//        this.memo = memo;
//    }
//
//
//}
