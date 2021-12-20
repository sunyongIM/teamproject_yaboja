package mc.sn.buyus.ybjService;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service("jwtService")
public class SecurityServiceImpl implements SecurityService {
//	private static final String SECRET_KEY = "aasjjkjaskjdl1k2naskjkdakj34c8sa";
	private static final String SECRET_KEY = "wpdl0ejqmfd9bxl9xhzmsdiqh5wk91";
	
	@Override
	public String createJWT(String subject, long ttlMillis) {
		if (ttlMillis <= 0) {
			throw new RuntimeException("Expiry time must be greater than Zero : [" + ttlMillis + "] ");
		} else {
			// 토큰을 서명하기 위해 사용해야할 알고리즘 선택
			SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

			byte[] secretKeyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);
			Key signingKey = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());
			return Jwts.builder()
					.setSubject(subject)
					.signWith(signatureAlgorithm, signingKey)
					.setExpiration(new Date(System.currentTimeMillis() + ttlMillis))
					.compact();
		}
	}

	@Override
	public String verifyJWT(String token) {
		Claims claims = Jwts.parser()
				.setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
				.parseClaimsJws(token)
				.getBody();
		return claims.getSubject();
	}
	
	
	
	/*
	 * public String makeJwtToken() { Date now = new Date();
	 * 
	 * return Jwts.builder() .setHeaderParam(Header.TYPE, Header.JWT_TYPE) // (1)
	 * .setIssuer("fresh") // (2) .setIssuedAt(now) // (3) .setExpiration(new
	 * Date(now.getTime() + Duration.ofMinutes(30).toMillis())) // (4) .claim("id",
	 * "아이디") // (5) .claim("email", "ajufresh@gmail.com")
	 * .signWith(SignatureAlgorithm.HS256, "secret") // (6) .compact(); }
	 * 
	 * protected void doFilterInternal(HttpServletRequest request,
	 * HttpServletResponse response, FilterChain filterChain) throws IOException,
	 * ServletException { String authorizationHeader =
	 * request.getHeader(HttpHeaders.AUTHORIZATION); Claims claims =
	 * jwtTokenProvider.parseJwtToken(authorizationHeader);
	 * 
	 * filterChain.doFilter(request, response); } public Claims parseJwtToken(String
	 * authorizationHeader) { validationAuthorizationHeader(authorizationHeader); //
	 * (1) String token = extractToken(authorizationHeader); // (2)
	 * 
	 * return Jwts.parser() .setSigningKey("secret") // (3) .parseClaimsJws(token)
	 * // (4) .getBody(); }
	 * 
	 * 
	 * private void validationAuthorizationHeader(String header) { if (header ==
	 * null || !header.startsWith("Bearer ")) { throw new
	 * IllegalArgumentException(); } }
	 * 
	 * private String extractToken(String authorizationHeader) { return
	 * authorizationHeader.substring("Bearer ".length()); }
	 */
}
