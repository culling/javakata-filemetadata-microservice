/// <reference types="cypress" />

describe("canary", () => {
    it("should always be true", () => {
        expect(true).to.equal(true);
    });
});

describe("POST to urlshortener", () => {
    it("should be able to make a rest request ", () => {
        cy.request({
            "url": "/plugins/servlet/urlshortener/api/shorturl",
            "method": "POST",
            "body": {
                original_url: 'https://freeCodeCamp.org',
                short_url: 1
            }
        });
    });
});

describe("GET from urlshortener", () => {
    it("should be able to make a rest request ", () => {
        cy.request({
            "url": "/plugins/servlet/urlshortener/api/shorturl",
            "method": "POST",
            "body": {
                original_url: 'https://www.freecodecamp.org',
                short_url: 1
            }
        });

        cy.visit("/plugins/servlet/urlshortener/api/shorturl/1");
        cy.location("href").should("eq", "https://www.freecodecamp.org/");
    });

    it("should get an error when trying an unset shorturl ", () => {
        cy.request({
            url: "/plugins/servlet/urlshortener/api/shorturl/expecterror",
            method: "GET",
            failOnStatusCode: false,
            
        }).should((response) =>{
            const json = response.body;
            expect(json.error).to.equal("invalid url");
        });
    });
});