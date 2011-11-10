/*
 * Copyright (C) 2011 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */
package com.google.android.voicemail.example.sms;

import com.google.android.voicemail.example.spec.Omtp;

import javax.annotation.concurrent.Immutable;

/**
 * An immutable implementation of {@link StatusMessage}.
 */
@Immutable
/*package*/ class StatusMessageImpl implements StatusMessage {
    // NOTE: Following Status SMS fields are not yet parsed, as they do not seem
    // to be useful for initial omtp source implementation.
    // lang, pw_len, pm, gm, vtc, vt

    private final Omtp.ProvisioningStatus mProvisioningStatus;
    private final Omtp.ReturnCode mStatusReturnCode;
    private final String mSubscriptionUrl;
    private final String mServerAddress;
    private final String mTuiAccessNumber;
    private final String mClientSmsDestinationNumber;
    private final String mImapPort;
    private final String mImapUserName;
    private final String mImapPassword;
    private final String mSmtpPort;
    private final String mSmtpUserName;
    private final String mSmtpPassword;
    private final Integer mMaxAllowedGreetingsLength;
    private final Integer mMaxAllowedVoiceSignatureLength;

    @Override
    public String toString() {
        return "StatusMessageImpl [mProvisioningStatus=" + mProvisioningStatus
                + ", mStatusReturnCode=" + mStatusReturnCode
                + ", mSubscriptionUrl=" + mSubscriptionUrl
                + ", mServerAddress=" + mServerAddress
                + ", mTuiAccessNumber=" + mTuiAccessNumber
                + ", mClientSmsDestinationNumber=" + mClientSmsDestinationNumber
                + ", mImapPort=" + mImapPort
                + ", mImapUserName=" + mImapUserName
                + ", mImapPassword=" + mImapPassword
                + ", mSmtpPort=" + mSmtpPort
                + ", mSmtpUserName=" + mSmtpUserName
                + ", mSmtpPassword=" + mSmtpPassword
                + ", mMaxAllowedGreetingsLength=" + mMaxAllowedGreetingsLength
                + ", mMaxAllowedVoiceSignatureLength=" + mMaxAllowedVoiceSignatureLength + "]";
    }

    public StatusMessageImpl(WrappedMessageData wrappedData) throws OmtpParseException {
        mProvisioningStatus = wrappedData.extractEnum(Omtp.StatusSmsField.PROVISIONING_STATUS,
                Omtp.ProvisioningStatus.class);
        mStatusReturnCode = wrappedData.extractEnum(Omtp.StatusSmsField.RETURN_CODE,
                Omtp.ReturnCode.class);
        mSubscriptionUrl = wrappedData.extractString(Omtp.StatusSmsField.SUBSCRIPTION_URL);
        mServerAddress = wrappedData.extractString(Omtp.StatusSmsField.SERVER_ADDRESS);
        mTuiAccessNumber = wrappedData.extractString(Omtp.StatusSmsField.TUI_ACCESS_NUMBER);
        mClientSmsDestinationNumber = wrappedData.extractString(
                Omtp.StatusSmsField.CLIENT_SMS_DESTINATION_NUMBER);
        mImapPort = wrappedData.extractString(Omtp.StatusSmsField.IMAP_PORT);
        mImapUserName = wrappedData.extractString(Omtp.StatusSmsField.IMAP_USER_NAME);
        mImapPassword = wrappedData.extractString(Omtp.StatusSmsField.IMAP_PASSWORD);
        mSmtpPort = wrappedData.extractString(Omtp.StatusSmsField.SMTP_PORT);
        mSmtpUserName = wrappedData.extractString(Omtp.StatusSmsField.SMTP_USER_NAME);
        mSmtpPassword = wrappedData.extractString(Omtp.StatusSmsField.SMTP_PASSWORD);
        mMaxAllowedGreetingsLength = wrappedData.extractInteger(
                Omtp.StatusSmsField.MAX_GREETINGS_LENGTH);
        mMaxAllowedVoiceSignatureLength = wrappedData.extractInteger(
                Omtp.StatusSmsField.MAX_VOICE_SIGNATURE_LENGTH);
    }

    @Override
    public void visit(OmtpMessage.Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getServerAddress() {
        return mServerAddress;
    }

    @Override
    public boolean hasServerAddress() {
        return mServerAddress != null;
    }

    @Override
    public String getSubscriptionUrl() {
        return mSubscriptionUrl;
    }

    @Override
    public boolean hasSubscriptionUrl() {
        return mSubscriptionUrl != null;
    }

    @Override
    public Omtp.ProvisioningStatus getProvisioningStatus() {
        return mProvisioningStatus;
    }

    @Override
    public boolean hasProvisioningStatus() {
        return mProvisioningStatus != null;
    }

    @Override
    public Omtp.ReturnCode getReturnCode() {
        return mStatusReturnCode;
    }

    @Override
    public boolean hasReturnCode() {
        return mStatusReturnCode != null;
    }

    @Override
    public String getTuiAccessNumber() {
        return mTuiAccessNumber;
    }

    @Override
    public boolean hasTuiAccessNumber() {
        return mTuiAccessNumber != null;
    }

    @Override
    public String getClientSmsDestinationNumber() {
        return mClientSmsDestinationNumber;
    }

    @Override
    public boolean hasClientSmsDestinationNumber() {
        return mClientSmsDestinationNumber != null;
    }

    @Override
    public String getImapPort() {
        return mImapPort;
    }

    @Override
    public boolean hasImapPort() {
        return mImapPort != null;
    }

    @Override
    public String getImapUserName() {
        return mImapUserName;
    }

    @Override
    public boolean hasImapUserName() {
        return mImapUserName != null;
    }

    @Override
    public String getImapPassword() {
        return mImapPassword;
    }

    @Override
    public boolean hasImapPassword() {
        return mImapPassword != null;
    }

    @Override
    public String getSmtpPort() {
        return mSmtpPort;
    }

    @Override
    public boolean hasSmtpPort() {
        return mSmtpPort != null;
    }

    @Override
    public String getSmtpUserName() {
        return mSmtpUserName;
    }

    @Override
    public boolean hasSmtpUserName() {
        return mSmtpUserName != null;
    }

    @Override
    public String getSmtpPassword() {
        return mSmtpPassword;
    }

    @Override
    public boolean hasSmtpPassword() {
        return mSmtpPassword != null;
    }

    @Override
    public int getMaxAllowedGreetingsLength() {
        return mMaxAllowedGreetingsLength;
    }

    @Override
    public boolean hasMaxAllowedGreetingsLength() {
        return mMaxAllowedGreetingsLength != null;
    }

    @Override
    public int getMaxAllowedVoiceSignatureLength() {
        return mMaxAllowedVoiceSignatureLength;
    }

    @Override
    public boolean hasMaxAllowedVoiceSignatureLength() {
        return mMaxAllowedVoiceSignatureLength != null;
    }
}
