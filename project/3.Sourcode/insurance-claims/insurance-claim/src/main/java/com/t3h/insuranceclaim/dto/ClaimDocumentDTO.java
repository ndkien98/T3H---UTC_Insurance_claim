package com.t3h.insuranceclaim.dto;

public class ClaimDocumentDTO {

    private Long id;
    private Long claimId;
    private String documentType;
    private byte[] content;
    
    // Getters and setters for each field
    public Long getId() { return id; }
    public Long getClaimid() { return claimId; }
    public String getDocumenttype() { return documentType; }
    public byte[] getContent() { return content; }
    public void setId(Long id) { this.id = id; }
    public void setClaimid(Long claimId) { this.claimId = claimId; }
    public void setDocumenttype(String documentType) { this.documentType = documentType; }
    public void setContent(byte[] content) { this.content = content; }
}
