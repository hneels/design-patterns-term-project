package program;

/* used this tutorial https://jvmaware.com/enum-as-factory/ as a reference */

/* since the ProgramFactory is an enum, it can be used anywhere throughout the application without creating a new instance.
Classes outside the package, like Student, can rely on only this factory to create new objects of Program subclasses.
Like so:
Program CsGraduateProgram = ProgramFactory.CS_GRAD.createProgram();
 */

// Factory pattern
public enum ProgramFactory {

    SECURITY_CERT {
        @Override
        public Program createProgram() {
            return new SecurityCertificate();
        }
    },
    WEB_CERT {
        @Override
        public Program createProgram() {
            return new WebCertificate();
        }
    },
    ANALYTICS_CERT {
        @Override
        public Program createProgram() {
            return new AnalyticsCertificate();
        }
    },
    CS_UNDERGRAD {
        @Override
        public Program createProgram() {
            return new CSUndergrad();
        }
    },
    CIS_UNDERGRAD {
        @Override
        public Program createProgram() {
            return new CISUndergrad();
        }
    },
    CS_GRAD {
        @Override
        public Program createProgram() {
            return new CSGradDegree();
        }
    },
    CIS_GRAD {
        @Override
        public Program createProgram() {
            return new CISGradDegree();
        }
    },
    DA_GRAD {
        @Override
        public Program createProgram() {
            return new DAGradDegree();
        }
    };

    // this abstract method is overridden by each of the possible enum literals above
    public abstract Program createProgram();
}