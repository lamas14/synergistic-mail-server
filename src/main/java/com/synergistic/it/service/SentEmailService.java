package com.synergistic.it.service;

import com.synergistic.it.email.spring.form.SentEmailForm;

public interface SentEmailService {

	public String uploadSentEmail(SentEmailForm sentEmailForm);
}
