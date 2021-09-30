package com.danzig.tenToOne.api;

public class StreamApi {

    private Long streamId;

    public StreamApi(Long streamId) {
        this.streamId = streamId;
    }

    public Long getStreamId() {
        return streamId;
    }

    public void setStreamId(Long streamId) {
        this.streamId = streamId;
    }
}
