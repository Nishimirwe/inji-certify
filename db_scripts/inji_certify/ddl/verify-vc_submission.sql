--
-- Table required by the embedded inji-verify library.
-- Stores individual VC results extracted during VP verification.

CREATE TABLE IF NOT EXISTS vc_submission (
    transaction_id character varying(40) NOT NULL,
    vc             text NOT NULL
);

COMMENT ON TABLE vc_submission IS 'Stores individual VC results from VP verification by the embedded inji-verify library';
COMMENT ON COLUMN vc_submission.transaction_id IS 'Transaction ID linking the VC result to the issuance session';
COMMENT ON COLUMN vc_submission.vc IS 'Base64-encoded or JSON VC extracted from the verified VP token';

CREATE INDEX IF NOT EXISTS idx_vc_submission_transaction_id ON vc_submission (transaction_id);
