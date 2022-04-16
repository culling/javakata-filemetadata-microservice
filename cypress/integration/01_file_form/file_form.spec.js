/// <reference types="cypress" />

describe("canary", () => {
    it("should always be true", () => {
        expect(true).to.equal(true);
    });
});

describe("Upload file to form", () => {
    it("should be able to make a form upload_1", () => {
        cy.visit("/plugins/servlet/filemetadata");

        cy.fixture('file/file_1.jpg').then(fileContent => {
            cy.get('input[type="file"]').attachFile({
                fileContent: fileContent.toString(),
                fileName: 'file_1.jpg',
                mimeType: 'image/jpeg'
            });
        });

        cy.get('#submit').click();

        cy.get("html").then(a =>{
            const json = JSON.parse(a[0].innerText);

            expect(json.fileName).to.equal("file_1.jpg");
            expect(json.contentType).to.equal("image/jpeg");
            expect(json.sizeInBytes).to.equal(7016808);
        });

    });

    it("should be able to make a form upload_2", () => {
        cy.visit("/plugins/servlet/filemetadata");

        cy.fixture('file/file_2.jpg').then(fileContent => {
            cy.get('input[type="file"]').attachFile({
                fileContent: fileContent.toString(),
                fileName: 'file_2.jpg',
                mimeType: 'image/jpeg'
            });
        });

        cy.get('#submit').click();

        cy.get("html").then(a =>{
            const json = JSON.parse(a[0].innerText);

            expect(json.fileName).to.equal("file_2.jpg");
            expect(json.contentType).to.equal("image/jpeg");
            expect(json.sizeInBytes).to.equal(902540);
        });

    });
});
