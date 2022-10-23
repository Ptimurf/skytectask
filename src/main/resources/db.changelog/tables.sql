CREATE TABLE IF NOT EXISTS "game"."clans"
(
    "id"    BIGINT      NOT NULL,
    "name"  VARCHAR(36) NOT NULL,
    "gold"  INTEGER     NOT NULL,
    CONSTRAINT "clans_pkey" PRIMARY KEY ("id")
);