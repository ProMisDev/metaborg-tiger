package mb.tiger.statix;

import mb.constraint.common.ConstraintAnalyzer;
import mb.constraint.common.ConstraintAnalyzerContext;
import mb.constraint.common.ConstraintAnalyzerException;
import mb.jsglr1.common.JSGLR1ParseResult;
import mb.log.api.LoggerFactory;
import mb.log.slf4j.SLF4JLoggerFactory;
import mb.resource.DefaultResourceKey;
import mb.resource.DefaultResourceService;
import mb.resource.DummyResourceRegistry;
import mb.resource.ResourceKey;
import mb.resource.ResourceService;
import mb.resource.fs.FSResourceRegistry;
import mb.resource.url.URLResourceRegistry;
import mb.stratego.common.StrategoRuntime;
import mb.stratego.common.StrategoRuntimeBuilder;
import mb.tiger.TigerConstraintAnalyzer;
import mb.tiger.TigerConstraintAnalyzerFactory;
import mb.tiger.TigerParser;
import mb.tiger.TigerParserFactory;
import mb.tiger.TigerStrategoRuntimeBuilderFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConstraintAnalyzerTest {
    private static final String qualifier = "test";

    private final TigerParser parser = new TigerParserFactory().create();
    private final String startSymbol = "Module";
    private final LoggerFactory loggerFactory = new SLF4JLoggerFactory();
    private final ResourceService resourceService = new DefaultResourceService(new DummyResourceRegistry(qualifier), new FSResourceRegistry(), new URLResourceRegistry());
    private final StrategoRuntimeBuilder strategoRuntimeBuilder = new TigerStrategoRuntimeBuilderFactory().create(loggerFactory, resourceService);
    private final StrategoRuntime strategoRuntime = strategoRuntimeBuilder.build();
    private final TigerConstraintAnalyzer analyzer = new TigerConstraintAnalyzerFactory(loggerFactory, resourceService, strategoRuntime).create();
    private final ResourceKey rootKey = new DefaultResourceKey(qualifier, "root");

    @Test void analyzeSingleSuccess() throws InterruptedException, ConstraintAnalyzerException {
        final ResourceKey resource = new DefaultResourceKey(qualifier, "a.tig");
        final JSGLR1ParseResult parsed = parser.parse("1 + 2", startSymbol, resource);
        assertTrue(parsed.getAst().isPresent());
        final ConstraintAnalyzer.SingleFileResult result =
            analyzer.analyze(rootKey, resource, parsed.getAst().get(), new ConstraintAnalyzerContext());
        assertNotNull(result.ast);
        assertNotNull(result.analysis);
        assertTrue(result.messages.isEmpty());
    }
}
