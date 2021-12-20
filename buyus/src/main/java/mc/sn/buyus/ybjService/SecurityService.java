package mc.sn.buyus.ybjService;

//@Service("jwtService")
public interface SecurityService {
	
	String createJWT(String subject, long ttlMillis);
	String verifyJWT(String token);
}
