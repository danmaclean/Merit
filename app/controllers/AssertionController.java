package controllers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import models.BadgeAssertion;
import models.IdentityHash;
import models.IdentityObject;
import models.IdentityType;
import models.VerificationObject;
import models.VerificationType;

import org.joda.time.DateTime;

import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class AssertionController extends Controller {

	public static Result assertions() {
		// list assertions

		List<BadgeAssertion> assertionsList = BadgeAssertion.find.all();

		return TODO;
	}

	public static Result createBadgeAssertion() {

		IdentityHash ih = new IdentityHash("user-email-address");

		boolean hashed = true;

		IdentityObject io = new IdentityObject(ih, IdentityType.email, hashed,
				ih.getSalt());

		// TODO make badge here

		URL badgeURL = null;
		try {
			badgeURL = new URL("TODO");
		} catch (MalformedURLException e2) {
			e2.printStackTrace();
		}

		URL verificationURL = null;
		try {
			verificationURL = new URL("TODO");
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}

		VerificationObject vo = new VerificationObject(VerificationType.hosted,
				verificationURL);

		DateTime issuedOn = new DateTime();
		URL image = null;
		try {
			image = new URL("http://127.0.0.1:9000/assets/images/badge.png");
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}

		URL evidence = null;
		try {
			evidence = new URL("TODO");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		DateTime expires = new DateTime();

		BadgeAssertion newBadgeAssertion = new BadgeAssertion(io, badgeURL, vo,
				issuedOn, image, evidence, expires);

		flash(Application.GLOBAL_FLASH_INFO, "Assertion added");		
		
		return ok(Json.toJson(newBadgeAssertion));

	}

}